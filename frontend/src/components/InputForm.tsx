import { useState } from 'react';
import { Button } from '@/components/ui/button';
import {
  SquarePen,
  StopCircle,
  Zap,
  Cpu,
  ContactRound,
  ArrowUp,
} from 'lucide-react';
import { Textarea } from '@/components/ui/textarea';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';

// Updated InputFormProps
interface InputFormProps {
  onSubmit: (inputValue: string, persona: string, model: string) => void;
  onCancel: () => void;
  isLoading: boolean;
  hasHistory: boolean;
}

export const InputForm: React.FC<InputFormProps> = ({
  onSubmit,
  onCancel,
  isLoading,
  hasHistory,
}) => {
  const [internalInputValue, setInternalInputValue] = useState('');
  const [persona, setPersona] = useState('product_owner');
  const [model, setModel] = useState('gpt-4o-mini');

  const handleInternalSubmit = (e?: React.FormEvent) => {
    if (e) e.preventDefault();
    if (!internalInputValue.trim()) return;
    onSubmit(internalInputValue, persona, model);
    setInternalInputValue('');
  };

  const handleKeyDown = (e: React.KeyboardEvent<HTMLTextAreaElement>) => {
    // Submit with Ctrl+Enter (Windows/Linux) or Cmd+Enter (Mac)
    if (e.key === 'Enter' && (e.ctrlKey || e.metaKey)) {
      e.preventDefault();
      handleInternalSubmit();
    }
  };

  const isSubmitDisabled = !internalInputValue.trim() || isLoading;

  return (
    <form
      onSubmit={handleInternalSubmit}
      className={`flex flex-col gap-4 p-6 pb-6 items-center`}
    >
      <div
        className={`flex flex-row items-center justify-between text-foreground rounded-3xl break-words min-h-7 bg-card border-2 border-border px-6 pt-4 pb-4 shadow-lg hover:shadow-xl transition-all duration-300 hover:scale-[1.02] w-full max-w-2xl`}
      >
        <Textarea
          value={internalInputValue}
          onChange={(e) => setInternalInputValue(e.target.value)}
          onKeyDown={handleKeyDown}
          placeholder="What is the average turnover of each country?"
          className={`w-full text-foreground placeholder-muted-foreground resize-none border-0 focus:outline-none focus:ring-0 outline-none focus-visible:ring-0 shadow-none
                        md:text-lg min-h-[60px] max-h-[200px] font-medium`}
          rows={1}
        />
        <div className="ml-3">
          {isLoading ? (
            <Button
              type="button"
              variant="ghost"
              size="icon"
              className="text-red-500 hover:text-red-400 hover:bg-red-500/20 p-3 cursor-pointer rounded-full transition-all duration-300 hover:scale-110 shadow-lg"
              onClick={onCancel}
            >
              <StopCircle className="h-6 w-6" />
            </Button>
          ) : (
            <Button
              type="submit"
              variant="ghost"
              className={`${
                isSubmitDisabled
                  ? 'text-muted-foreground'
                  : 'text-primary hover:text-primary/80 hover:bg-primary/20 bg-primary/20 shadow-lg hover:shadow-xl'
              } p-3 cursor-pointer rounded-full transition-all duration-300 text-lg font-semibold hover:scale-110`}
              disabled={isSubmitDisabled}
            >
              Send
              <ArrowUp className="h-5 w-5 ml-1" />
            </Button>
          )}
        </div>
      </div>
      <div className="flex items-center justify-center w-full">
        <div className="flex flex-row gap-4 items-center">
          <div className="flex flex-row gap-3 bg-card border-2 border-border text-card-foreground focus:ring-ring rounded-2xl px-4 py-3 shadow-md hover:shadow-lg transition-all duration-300 hover:scale-105">
            <div className="flex flex-row items-center text-sm font-medium">
              <ContactRound className="h-5 w-5 mr-2 text-blue-500" />
              Database
            </div>
            <Select value={persona} onValueChange={setPersona}>
              <SelectTrigger className="w-[140px] bg-transparent border-none cursor-pointer font-medium">
                <SelectValue placeholder="Persona" />
              </SelectTrigger>
              <SelectContent className="bg-card border border-border text-card-foreground cursor-pointer">
                <SelectItem
                  value="product_owner"
                  className="hover:bg-accent focus:bg-accent cursor-pointer font-medium"
                >
                  Product Owner
                </SelectItem>
                <SelectItem
                  value="marketing"
                  className="hover:bg-accent focus:bg-accent cursor-pointer font-medium"
                >
                  Marketing
                </SelectItem>
              </SelectContent>
            </Select>
          </div>
          <div className="flex flex-row gap-3 bg-card border-2 border-border text-card-foreground focus:ring-ring rounded-2xl px-4 py-3 shadow-md hover:shadow-lg transition-all duration-300 hover:scale-105">
            <div className="flex flex-row items-center text-sm font-medium">
              <Cpu className="h-5 w-5 mr-2 text-purple-500" />
              Model
            </div>
            <Select value={model} onValueChange={setModel}>
              <SelectTrigger className="w-[160px] bg-transparent border-none cursor-pointer font-medium">
                <SelectValue placeholder="Model" />
              </SelectTrigger>
              <SelectContent className="bg-card border border-border text-card-foreground cursor-pointer">
                <SelectItem
                  value="gpt-3.5-turbo"
                  className="hover:bg-accent focus:bg-accent cursor-pointer font-medium"
                >
                  <div className="flex items-center">
                    <Zap className="h-4 w-4 mr-2 text-yellow-400" />{' '}
                    gpt-3.5-turbo
                  </div>
                </SelectItem>
                <SelectItem
                  value="gpt-4o-mini"
                  className="hover:bg-accent focus:bg-accent cursor-pointer font-medium"
                >
                  <div className="flex items-center">
                    <Zap className="h-4 w-4 mr-2 text-orange-400" /> gpt-4o-mini
                  </div>
                </SelectItem>
                <SelectItem
                  value="gpt-4o"
                  className="hover:bg-accent focus:bg-accent cursor-pointer font-medium"
                >
                  <div className="flex items-center">
                    <Cpu className="h-4 w-4 mr-2 text-purple-400" /> gpt-4o
                  </div>
                </SelectItem>
              </SelectContent>
            </Select>
          </div>
        </div>
        {hasHistory && (
          <Button
            className="bg-card border-2 border-border text-card-foreground cursor-pointer rounded-2xl px-4 py-3 shadow-md hover:shadow-lg transition-all duration-300 hover:scale-105 font-medium"
            variant="default"
            onClick={() => window.location.reload()}
          >
            <SquarePen size={18} className="mr-2" />
            New Search
          </Button>
        )}
      </div>
    </form>
  );
};
